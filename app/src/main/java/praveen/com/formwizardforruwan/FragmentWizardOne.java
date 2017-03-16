package praveen.com.formwizardforruwan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Praveen Amarasinghe on 06/03/2017.
 */

public class FragmentWizardOne extends Fragment {

    public static final String FORM_DATA = "form_data";
    private AppCompatEditText fullNameEditText;
    private AppCompatEditText emailEditText;

    private AppCompatButton nextButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wizard_one, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        fullNameEditText = (AppCompatEditText) view.findViewById(R.id.wizard_one_full_name_text);
        emailEditText = (AppCompatEditText) view.findViewById(R.id.wizard_one_email_text);
        nextButton = (AppCompatButton) view.findViewById(R.id.wizard_one_next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormObject formObject = new FormObject();
                formObject.setFullName(fullNameEditText.getText().toString());
                formObject.setEmail(emailEditText.getText().toString());


                Bundle bundle = new Bundle();
                bundle.putSerializable(FORM_DATA, formObject);
                FragmentWizardTwo fragmentWizardTwo = new FragmentWizardTwo();
                fragmentWizardTwo.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragmentWizardTwo)
                        .commit();
            }
        });
    }
}
