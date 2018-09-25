package suleyman.regexp;

import android.widget.*;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends Activity {

	private EditText etText, etRegExp;
	private TextView tvResult;
	
	private Pattern pattern;
	private Matcher matcher;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		etText = (EditText) findViewById(R.id.etText);
		etRegExp = (EditText) findViewById(R.id.etRegExp);

		tvResult = (TextView) findViewById(R.id.tvResult);
		
		etText.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
				}

				@Override
				public void afterTextChanged(Editable editable) {
					if (pattern != null) {
						
						matcher = pattern.matcher(editable.toString());
						
						if (matcher.find()) {
							tvResult.setText(matcher.group());
						} else {
							tvResult.setText("");
						}
					}
				}
		});

		etRegExp.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {

				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {

				}

				@Override
				public void afterTextChanged(Editable editable) {
					String text = etText.getText().toString();
					try {
						pattern = Pattern.compile(editable.toString());

						matcher = pattern.matcher(text);

						if (matcher.find()) {
							tvResult.setText(matcher.group());
						} else {
							tvResult.setText("");
						}
					} catch (Exception e) {
						tvResult.setText("Syntax error");
					}

				}
			});

    }
}
