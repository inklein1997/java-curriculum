package com.company;

public class Basement extends Room {
    private boolean finished;
    private String sumpPumpModel;

    public String getSumpPumpModel() {
        return sumpPumpModel;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setSumpPumpModel(String sumpPumpModel) {
        this.sumpPumpModel = sumpPumpModel;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
