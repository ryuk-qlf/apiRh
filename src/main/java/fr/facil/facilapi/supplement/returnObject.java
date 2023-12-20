package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class returnObject {

    private Object result;

    public returnObject(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
