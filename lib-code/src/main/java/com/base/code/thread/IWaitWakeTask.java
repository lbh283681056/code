package com.base.code.thread;

/**
 * Created by linbinghuang on 2016/12/9.
 * 等待唤醒接口
 */
public interface IWaitWakeTask {

    //运行的主要逻辑
    void run();
    //是否等待
    boolean isWait();
    //唤醒
    void wake(Object... objects);
}
