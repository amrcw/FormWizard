package praveen.com.formwizardforruwan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Praveen Amarasinghe on 06/03/2017.
 */

public class FragmentWizardThree extends Fragment {

    private AppCompatTextView nameView;
    private AppCompatTextView emailView;
    private AppCompatTextView selecteValueView;
    private AppCompatTextView selecteValueSummary;

    private AppCompatButton finishButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wizard_third, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        nameView = (AppCompatTextView) view.findViewById(R.id.wizard_last_name);
        emailView = (AppCompatTextView) view.findViewById(R.id.wizard_last_email);
        selecteValueView = (AppCompatTextView) view.findViewById(R.id.wizard_last_selected_number);
        selecteValueSummary = (AppCompatTextView) view.findViewById(R.id.wizard_last_summary);

        finishButton = (AppCompatButton) view.findViewById(R.id.wizard_last_finish_button);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Wizard Completed !", Toast.LENGTH_SHORT).show();
            }
        });

        FormObject formObject = (FormObject) getArguments().getSerializable(FragmentWizardOne.FORM_DATA);

        nameView.setText(formObject.getFullName());
        emailView.setText(formObject.getEmail());
        selecteValueView.setText(formObject.getSelectedValue());
        selecteValueSummary.setText(formObject.getValueSummary());
    }
}
