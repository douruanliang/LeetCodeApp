package com.github.designpatternlibrary;


/**
 * @author: dourl
 * @date: 2020/6/10
 */
public class Bridger {

    abstract class Messager {
        //组合
        protected MessageImp messageImp;

        public Messager(MessageImp messageImp) {
            this.messageImp = messageImp;
        }

        public abstract void login(String username, String password);

    }

    abstract class MessageImp {
        public abstract void play();

        public abstract void connect();
    }


    //平台 1似的抽象和实现可以沿着各自的纬度来变化，及子类话

    class PCMessagerImp extends MessageImp {

        @Override
        public void play() {

        }

        @Override
        public void connect() {

        }
    }


    /**
     * 似的抽象和实现可以沿着各自的纬度来变化，及子类话
     */
    //平台 2

    class MobileMessageImp extends MessageImp {

        @Override
        public void play() {

        }

        @Override
        public void connect() {

        }
    }


}
