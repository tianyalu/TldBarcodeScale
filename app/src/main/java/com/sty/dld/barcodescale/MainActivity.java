package com.sty.dld.barcodescale;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mt.rt.aoapi.AOScale;
import com.mt.rt.aoapi.DataType;
import com.sty.dld.barcodescale.bean.Barcode;
import com.sty.dld.barcodescale.bean.BarcodeWrapper;
import com.sty.dld.barcodescale.bean.Label;
import com.sty.dld.barcodescale.bean.TldErrorCode;
import com.sty.dld.barcodescale.bean.TldPluData;
import com.sty.dld.barcodescale.bean.TldPluDataWrapper;
import com.sty.dld.barcodescale.util.FileUtil;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String LABEL_FILE_NAME = "LBL00001.xml";
    private static final String TARGET_PATH = Environment.getExternalStorageDirectory() + "/hgs/" + LABEL_FILE_NAME;
    private Button btnWriteLabel;
    private Button btnWriteData;
    private Button btnWriteBarcode;
    private AOScale mAOScale;
    private Pair<String, Integer> ipAddress;
    private List<Pair<String, Integer>> scales;
    private int pluNum = 100100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        copyLabelFile();
    }

    private void copyLabelFile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileUtil.copyAssetsFile(MainActivity.this, LABEL_FILE_NAME, TARGET_PATH);
            }
        }).start();
    }

    private void initView() {
        btnWriteLabel = findViewById(R.id.btn_write_label);
        btnWriteData = findViewById(R.id.btn_write_data);
        btnWriteBarcode = findViewById(R.id.btn_write_barcode);

        mAOScale = new AOScale(mHandler);
        ipAddress = new Pair<>("192.168.1.230", 3001);
        scales = new ArrayList<>();
        scales.add(ipAddress);

        btnWriteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writePluData();
            }
        });
        btnWriteBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeBarcode();
            }
        });

        btnWriteLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLabels();
            }
        });
    }

    private void writeBarcode() {

        List<Barcode> barcodeList = new ArrayList<>();
        Barcode barcode = new Barcode();
        barcode.setId("5");
//        barcode.setType("EAN13");
        //barcode.setType("EAN128");

        barcode.setType("QRCode");
        //barcode.setDescription(String.valueOf(pluNum));
        barcode.setDescription("adv barcode");
//        barcode.setDefinition("24PPPPPBBBBBC");
        //barcode.setDefinition("24PPPPPQQQQQQMMMMMMC");
        barcode.setDefinition("6PPPPPPMMMMMQQQQQC");

        //barcode.setDefinition("$R(Registration -Separator 13[$D(ItemDescription -l 10)$D(TransactionNetWeight -l 5)$D(TransactionUnitPrice -l 5)$D(TransactionTotalPrice -l 5)])");
        barcodeList.add(barcode);
        BarcodeWrapper barcodeWrapper = new BarcodeWrapper();
        barcodeWrapper.setBarcodes(barcodeList);

        String barcodeStr = new Gson().toJson(barcodeWrapper);
        try {
            JSONObject barcodeJSONObject = new JSONObject(barcodeStr);
            mAOScale.write(scales, DataType.BARCODE, barcodeJSONObject);
            Log.d(TAG, "barcode Str: " + barcodeStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void writePluData() {

        try {
            List<TldPluData> pluDataList = new ArrayList<>();

            TldPluData pluData = new TldPluData();
            pluData.setPlu(String.valueOf(pluNum));
            List<String> descriptions = new ArrayList<>();
            descriptions.add("2级牛肉");
            pluData.setDescriptions(descriptions);
            TldPluData.PriceABean priceABean = new TldPluData.PriceABean();
            priceABean.setType("BasePrice");
            priceABean.setValue(60.05);
            priceABean.setUom("KGM");
            priceABean.setDiscount(true);
            priceABean.setOverride(true);
            pluData.setPriceA(priceABean);
            pluData.setBarcode(5);
            List<Integer> labels = new ArrayList<>();
            labels.add(1);
            pluData.setLabels(labels);
            pluDataList.add(pluData);

            TldPluDataWrapper tldPluDataWrapper = new TldPluDataWrapper();
            tldPluDataWrapper.setData(pluDataList);

            String pluDataStr = new Gson().toJson(tldPluDataWrapper);
            JSONObject pluJSONObject = new JSONObject(pluDataStr);
            Log.d(TAG, "plu data: " + pluJSONObject.toString());
            mAOScale.write(scales, DataType.PLUET, pluJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void writeLabels() {
        Label.LabelBean bean = new Label.LabelBean();
        Log.d(TAG, "path: " + TARGET_PATH);
        bean.setPath(TARGET_PATH);
        Label label = new Label();
        label.setLabels(bean);
        String labelStr = new Gson().toJson(label);
        try {
            JSONObject labelJSONObject = new JSONObject(labelStr);
            mAOScale.write(scales, DataType.LABEL, labelJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case AOScale.EVT_COMM_TRANSMITION_BEGIN:
                    //开始向一台电子秤写入数据
                    Log.d(TAG, "开始向一台电子秤写入数据");
                    break;
                case AOScale.EVT_COMM_TRANSMITION_END:
                    //结束向一台电子秤写入数据
                    Log.d(TAG, "结束向一台电子秤写入数据");
                    break;
                case AOScale.EVT_COMM_WAITE_ALL_END:
                    //向所有电子秤的写入均已结束
                    //调用如下函数获取所有的结果
                    List<Integer> retList = mAOScale.getWriteErrorCode();
                    Log.d(TAG, "向所有电子秤的写入均已结束 retList0: " + retList.get(0));
                    break;
                case AOScale.EVT_COMM_SENDDATA_SECCESS:
                    //成功向电子秤写入数据
                    Log.d(TAG, "成功向电子秤写入数据");
                    Toast.makeText(MainActivity.this, "成功向电子秤写入数据", Toast.LENGTH_SHORT).show();
                    break;
                case AOScale.EVT_SOCKET_OPEN_FAILED:
                    //初始化和电子秤的连接失败
                case AOScale.EVT_SOCKET_CONNECT_FAILED:
                    //连接电子秤失败
                case AOScale.EVT_SOCKET_CONNECT_EXCEPTION:
                    //连接到电子秤时出错（捕获到异常），可以检查日志查找错误原因
                    //todo 展示输入IP地址对话框
                    break;
                default:
                    String errorMsg = TldErrorCode.getErrorMsg(msg.what);
                    Log.d(TAG, errorMsg);
                    Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mAOScale != null) {
            mAOScale.cleanup();
        }
    }
}