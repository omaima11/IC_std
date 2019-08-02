package com.example.my;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;


public class Video extends Fragment implements Connector.IConnect {


    Button btn_start,btn_connect,btn_disconnect;
    private Connector vc;
    private FrameLayout videoFrame;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.video, container, false);

        ConnectorPkg.setApplicationUIContext(getActivity());
        ConnectorPkg.initialize();
        videoFrame = v.findViewById(R.id.videoframe);
        btn_connect=v.findViewById(R.id.btn_connect);

        btn_start=v.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start();
            }
        });

        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connect();
            }
        });


        return v;
    }

    public void Start() {
        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
    }

    public void Connect() {
        String token = "here you must login in their website and generate token prod.vidyo.io";
        vc.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", this);
    }

    public void Disconnect() {
        vc.disconnect();
    }

    public void onSuccess() {
    }

    public void onFailure(Connector.ConnectorFailReason reason) {
    }

    public void onDisconnected(Connector.ConnectorDisconnectReason reason) {
    }


}

