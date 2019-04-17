package com.tent.common.entity;

import net.sf.json.JSONObject;

import java.util.Map;

public class Consts {

    public static enum BoolType implements IConst{
        YES(1,"是"),
        NO(0,"否");

        public static BoolType get(int i){
            switch (i){
                case 0:
                    return BoolType.NO;
                case 1:
                    return BoolType.YES;
            }
            return null;
        }

        private int nCode;
        private String nLable;

        BoolType(int nCode, String nLable) {
            this.nCode = nCode;
            this.nLable = nLable;
        }

        @Override
        public int val() {
            return this.nCode;
        }

        @Override
        public String label() {
            return this.nLable;
        }

        @Override
        public int getVal() {
            return this.nCode;
        }

        @Override
        public String getLabel() {
            return this.nLable;
        }

        @Override
        public IConst[] vals() {
            return BoolType.values();
        }

        @Override
        public IConst valof(String str) {
            return BoolType.valueOf(str);
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
    public static enum AuthenticateType implements  IConst{
        No(0,"注册会员"),
        PERSONAL(10,"个人认证"),
        Company(20,"企业认证");
        public  static AuthenticateType get(int i){
            switch(i)
            {
                case 0:
                    return AuthenticateType.No;
                case 10:
                    return AuthenticateType.PERSONAL;
                case 20:
                    return AuthenticateType.Company;
            }
            return null;
        }
        private   int   nCode ;
        private   String   nLabel ;
        AuthenticateType (int   _nCode,String _nlabel) {
            this. nCode  = _nCode;
            this.nLabel=_nlabel;
        }

        @Override
        public int val(){
            return nCode;
        }
        @Override
        public String label(){
            return nLabel;
        }
        @Override
        public String getLabel(){
            return nLabel;
        }
        @Override
        public int getVal(){
            return nCode;
        }
        @Override
        public IConst[] vals(){
            return AuthenticateType.values();
        }

        @Override
        public IConst valof(String str) {
            return AuthenticateType.valueOf(str);
        }
        @Override
        public boolean isEq(int i) {
            return nCode==i;
        }

        @Override
        public boolean isNot(int i) {
            return nCode!=i;
        }

    }
}
