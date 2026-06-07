package com.example.budi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Views
        Spinner spinnerType = findViewById(R.id.spinnerPetrolType);
        EditText etPrice = findViewById(R.id.etPrice);
        EditText etUsage = findViewById(R.id.etUsage);
        Switch switchBudi = findViewById(R.id.switchBudi);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        TextView tvTotalCost = findViewById(R.id.tvTotalCost);
        TextView tvRebate = findViewById(R.id.tvRebate);
        TextView tvFinalAmount = findViewById(R.id.tvFinalAmount);

        // 2. Set Button Click Listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceStr = etPrice.getText().toString();
                String usageStr = etUsage.getText().toString();

                // Check if inputs are empty
                if (!priceStr.isEmpty() && !usageStr.isEmpty()) {
                    double price = Double.parseDouble(priceStr);
                    double usage = Double.parseDouble(usageStr);
                    String type = spinnerType.getSelectedItem().toString();
                    boolean isEligible = switchBudi.isChecked();

                    // Step 1: Total petrol cost = fuel usage x petrol price per liter [cite: 25]
                    double totalCost = usage * price;

                    // Step 2: BUDI rebate = fuel usage x subsidy rate (RM1.99/l) *for RON95 only [cite: 28]
                    double rebate = 0.0;
                    if (type.equals("RON95") && isEligible) {
                        rebate = usage * 1.99;
                    }

                    // Step 3: Total saving (Final Payable) = Total petrol cost - BUDI rebate [cite: 31]
                    double finalPayable = totalCost - rebate;

                    // Display outputs formatted to 2 decimal places
                    tvTotalCost.setText(String.format("Total Petrol Cost: RM %.2f", totalCost));
                    tvRebate.setText(String.format("BUDI Rebate: RM %.2f", rebate));
                    tvFinalAmount.setText(String.format("Final Payable (Total Saving): RM %.2f", finalPayable));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // --- Navigation Menu Setup ---

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflates the menu we created in res/menu/main_menu.xml
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handles menu item clicks
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Go to AboutActivity
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_home) {
            // Already on Home, do nothing
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}