package com.tent.common.web;


import com.tent.common.entity.Consts;
import com.tent.common.entity.IConst;

public class ConstsTag {

    public ConstsTag() {

    }

    public static class TagBoolType extends BaseTag {
        public TagBoolType() {
        }

        public IConst GetConst(int val) {
            return Consts.BoolType.get(val);
        }

        public void setNo(int val) {
            this.setCurrentconst(Consts.BoolType.NO, val);
        }

        public void setYes(int val) {
            this.setCurrentconst(Consts.BoolType.YES, val);
        }

        public IConst[] GetVals() {
            return Consts.BoolType.values();
        }
    }

}
