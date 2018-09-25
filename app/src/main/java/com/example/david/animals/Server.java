package com.example.david.animals;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class Server {
    MainActivity activity;
    ServerSocket serverSocket;
    String message = "";
    static final int socketServerPORT = 8080;

    //need to change activity received to new activity
    public Server(MainActivity activity) {
        this.activity = activity;
        //Thread socketServerThread = new Thread(new SocketServerThread());
        //socketServerThread.start();
    }
    public Server() {


                Runnable runnable = new Runnable() {
                    public void run() {

                        long endTime = System.currentTimeMillis()
                                + 20 * 1000;

                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime -
                                            System.currentTimeMillis());
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                };
                Thread mythread = new Thread(runnable);
                mythread.start();
        }
                //Thread socketServerThread = new Thread(new SocketServerThread());
                //socketServerThread.start();

//
//            public int getPort() {
//                return socketServerPORT;
//            }
//
//            public void onDestroy() {
//                if (serverSocket != null) {
//                    try {
//                        serverSocket.close();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
////    }
////    //Creates a new threapublic class ThreadExampleActivity extends ActionBarActivity {
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            TextView myTextView =
//                    (TextView)findViewById(R.id.myTextView);
//            myTextView.setText("Button Pressed");
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thread_example);
//    }
//.
//        .
//        .
//}
//
//    public void buttonClick(View view)
//    {
//
//        Runnable runnable = new Runnable() {
//            public void run() {
//
//                long endTime = System.currentTimeMillis() +
//                        20*1000;
//
//                while (System.currentTimeMillis() < endTime) {
//                    synchronized (this) {
//                        try {
//                            wait(endTime -
//                                    System.currentTimeMillis());
//                        } catch (Exception e) {}
//                    }
//
//                }
//                handler.sendEmptyMessage(0);
//            }
//        };
//
//        Thread mythread = new Thread(runnable);
//        mythread.start();d
//
//
//        public class ThreadExampleActivity extends ActionBarActivity {
//
//            Handler handler = new Handler() {
//                @Override
//                public void handleMessage(Message msg) {
//                    TextView myTextView =
//                            (TextView)findViewById(R.id.myTextView);
//                    myTextView.setText("Button Pressed");
//                }
//            };
//
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_thread_example);
//            }
//.
//        .
//        .
//        }
//
//        public void buttonClick(View view)
//        {
//
//            Runnable runnable = new Runnable() {
//                public void run() {
//
//                    long endTime = System.currentTimeMillis() +
//                            20*1000;
//
//                    while (System.currentTimeMillis() < endTime) {
//                        synchronized (this) {
//                            try {
//                                wait(endTime -
//                                        System.currentTimeMillis());
//                            } catch (Exception e) {}
//                        }
//
//                    }
//                    handler.sendEmptyMessage(0);
//                }
//            };
//
//            Thread mythread = new Thread(runnable);
//            mythread.start();
//    private class SocketServerThread extends Thread {
//
//        int count = 0;
//
//        @Override
//        //has to implement run in thread
//        public void run() {
//            try {
//                serverSocket = new ServerSocket(socketServerPORT);
////creates a looper on the thread
//                while (true) {
//                    Socket socket = serverSocket.accept();
//                    count++;
//                    message += "#" + count + " from "
//                            + socket.getInetAddress() + ":"
//                            + socket.getPort() + "\n";
//
//                    activity.runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            activity.msg.setText(message);
//                        }
//                    });
////Call to create new thread
//                    SocketServerReplyThread socketServerReplyThread = new SocketServerReplyThread(
//                            socket, count);
//                    socketServerReplyThread.run();
//
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//    }
//    //receives the call and creates a new thread
//    private class SocketServerReplyThread extends Thread {
//
//        private Socket hostThreadSocket;
//        int cnt;
//
//        SocketServerReplyThread(Socket socket, int c) {
//            hostThreadSocket = socket;
//            cnt = c;
//        }
//
//        @Override
//        //overrides run method and prints a message to the outputstream for socket 8080
//        public void run() {
//            OutputStream outputStream;
//            String msgReply = "Hello from Server, you are #" + cnt;
//
//            try {
//                outputStream = hostThreadSocket.getOutputStream();
//                PrintStream printStream = new PrintStream(outputStream);
//                printStream.print(msgReply);
//                printStream.close();
//
//                message += "replayed: " + msgReply + "\n";
//
//                activity.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        activity.msg.setText(message);
//                    }
//                });
//
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                message += "Something wrong! " + e.toString() + "\n";
//            }
//
//            activity.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    activity.msg.setText(message);
//                }
//            });
//        }
//
//    }
//
//    public String getIpAddress() {
//        String ip = "";
//        try {
//            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
//                    .getNetworkInterfaces();
//            while (enumNetworkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = enumNetworkInterfaces
//                        .nextElement();
//                Enumeration<InetAddress> enumInetAddress = networkInterface
//                        .getInetAddresses();
//                while (enumInetAddress.hasMoreElements()) {
//                    InetAddress inetAddress = enumInetAddress
//                            .nextElement();
//
//                    if (inetAddress.isSiteLocalAddress()) {
//                        ip += "Server running at : "
//                                + inetAddress.getHostAddress();
//                    }
//                }
//            }
//
//        } catch (SocketException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            ip += "Something Wrong! " + e.toString() + "\n";
//        }
//        return ip;
//    }
        };


