package com.tent.common.entity;

public class Consts {

    public static enum MemberType implements IConst{
        EXCHANGE(0,"交易中心"),
        MEMBER(1,"交易会员"),
        Chain(2,"供应链会员");

        public static MemberType get(int i){
            switch (i){
                case 0:
                    return MemberType.EXCHANGE;
                case 1:
                    return MemberType.MEMBER;
                case 2:
                    return MemberType.Chain;
            }
            return null;
        }

        private int nCode;
        private String nLable;

        MemberType(int nCode, String nLable) {
            this.nCode = nCode;
            this.nLable = nLable;
        }

        @Override
        public int val() {
            return nCode;
        }

        @Override
        public String label() {
            return nLable;
        }

        @Override
        public int getVal() {
            return nCode;
        }

        @Override
        public String getLabel() {
            return nLable;
        }

        @Override
        public IConst[] vals() {
            return MemberType.values();
        }

        @Override
        public IConst valof(String str) {
            return MemberType.valueOf(str);
        }

        @Override
        public boolean isEq(int i) {
            return i == nCode;
        }

        @Override
        public boolean isNot(int i) {
            return i != nCode;
        }

    }
}
