package praveen.com.formwizardforruwan;

import java.io.Serializable;

/**
 * Created by Praveen Amarasinghe on 06/03/2017.
 */

public class FormObject implements Serializable {

    private String fullName;
    private String email;
    private String selectedValue;
    private String valueSummary;

    public FormObject() {
    }

    public FormObject(String fullName, String email, String selectedValue, String valueSummary) {
        this.fullName = fullName;
        this.email = email;
        this.selectedValue = selectedValue;
        this.valueSummary = valueSummary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getValueSummary() {
        return valueSummary;
    }

    public void setValueSummary(String valueSummary) {
        this.valueSummary = valueSummary;
    }
}
