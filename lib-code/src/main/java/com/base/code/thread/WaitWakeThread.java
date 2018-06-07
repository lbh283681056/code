package com.base.code.thread;

/**
 * Created by linbinghuang on 2016/12/9.
 * 等待唤醒线程
 */
public class WaitWakeThread extends Thread {
    private IWaitWakeTask mCallback;
    private Object lock = new Object();

    /**
     * 属性 mCallback 必须要加入回调
     */
    public WaitWakeThread(IWaitWakeTask mCallback) {
        this.mCallback = mCallback;
    }

    private WaitWakeThread() {
    }
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                synchronized (lock) {
                    if (mCallback.isWait()) {
                        lock.wait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加操作
     * 属性 objects
     */
    public void wake(Object... objects) {
        synchronized (lock) {
            mCallback.wake(objects);
            lock.notify();
        }
    }
}
