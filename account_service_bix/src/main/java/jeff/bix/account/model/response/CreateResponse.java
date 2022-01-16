package jeff.bix.account.model.response;

import java.sql.ResultSet;

public class CreateResponse {
    private RESUST_STATE resultState;
    private String msg;

    public RESUST_STATE getResultState() {
        return resultState;
    }

    public void setResultState(RESUST_STATE resultState) {
        this.resultState = resultState;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
