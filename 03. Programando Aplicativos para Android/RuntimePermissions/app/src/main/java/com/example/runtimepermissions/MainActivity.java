package com.example.runtimepermissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQ_CODE) {
            if (permissions.length > 0 && permissions[0].equals(Manifest.permission.CAMERA) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkCamera();
            } else {
                Toast.makeText(this,"Acesso a Câmera não autorizado",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkCamera() {

        checkPermission();

        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            String[] ids = cameraManager.getCameraIdList();
            cameraManager.openCamera(ids[0], new CameraDevice.StateCallback() {
                @Override
                public void onOpened(@NonNull CameraDevice cameraDevice) {
                    Toast.makeText(MainActivity.this, "Câmera aberta", Toast.LENGTH_SHORT).show();
                    cameraDevice.close();
                }

                @Override
                public void onDisconnected(@NonNull CameraDevice cameraDevice) {
                    cameraDevice.close();
                }

                @Override
                public void onError(@NonNull CameraDevice cameraDevice, int i) {
                    cameraDevice.close();
                }
            }, null);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPermission(){
        //Permission checking on runtime, only for API 23 or higher
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                //Show info to user about why to accept permission
                Toast.makeText(this,"Esta permissão é importante!",Toast.LENGTH_SHORT).show();
            } else {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQ_CODE);
            }
            return true;
        } else {
            Toast.makeText(this,"Permissão já concedida", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
