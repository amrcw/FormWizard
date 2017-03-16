package praveen.com.formwizardforruwan;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class FragmentWizardTwo extends Fragment implements AdapterView.OnItemSelectedListener{

    private AppCompatSpinner spinner;
    private AppCompatEditText summaryEditText;
    private TextInputLayout summaryEditLayout;
    private AppCompatButton nextButton;

    private String selectedValue;

    public FragmentWizardTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wizard_second, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        spinner = (AppCompatSpinner) view.findViewById(R.id.wizard_two_spinner);
        summaryEditLayout = (TextInputLayout) view.findViewById(R.id.wizard_two_summary_layout);
        summaryEditText = (AppCompatEditText) view.findViewById(R.id.wizard_two_summary_editText);
        nextButton = (AppCompatButton) view.findViewById(R.id.wizard_two_next_button);

        spinner.setAdapter(setSpinnerAdapter());
        spinner.setOnItemSelectedListener(this);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FormObject formObject = (FormObject) getArguments().getSerializable(FragmentWizardOne.FORM_DATA);
                formObject.setSelectedValue(selectedValue);
                formObject.setValueSummary(summaryEditText.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putSerializable(FragmentWizardOne.FORM_DATA, formObject);
                FragmentWizardThree fragmentWizardThree = new FragmentWizardThree();
                fragmentWizardThree.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragmentWizardThree)
                        .commit();

            }
        });
    }

    private ArrayAdapter<CharSequence> setSpinnerAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.numbers_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TAG", ""+parent.getItemAtPosition(position).toString());

        selectedValue = parent.getItemAtPosition(position).toString();

        if(position == 2) {
            summaryEditLayout.setVisibility(View.VISIBLE);
        } else {
            summaryEditLayout.setVisibility(View.GONE);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
