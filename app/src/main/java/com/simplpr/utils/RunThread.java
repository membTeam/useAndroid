package com.simplpr.utils;

public class RunThread implements Runnable {

    public Thread thread;

    public RunThread() {
        thread = new Thread(this, "getRESTapi");
    }

    @Override
    public void run() {
        RESTapi.backgroundThreadProcessing();
    }
}
