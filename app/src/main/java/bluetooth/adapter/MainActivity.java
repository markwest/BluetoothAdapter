package bluetooth.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import bluetooth.adapter.dto.BluetoothAdapterDto;
import bluetooth.adapter.service.BluetoothAdapterService;
import bluetooth.adapter.service.IBluetoothAdapterService;

/**
 * Starting point of the application
 */
public class MainActivity extends AppCompatActivity {

    IBluetoothAdapterService bluetoothAdapterService;
    BluetoothAdapterDto bluetoothAdapterDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.activity_main_title);

        if (savedInstanceState == null) {

            bluetoothAdapterService = new BluetoothAdapterService(this);
            bluetoothAdapterDto = bluetoothAdapterService.getBluetoothAdapterDto();

            if (bluetoothAdapterDto.getError() != null) {
                String name = bluetoothAdapterDto.getName();
                TextView view = findViewById(R.id.name_textView);
                view.setText(name);

                String address = bluetoothAdapterDto.getAddress();
                view = findViewById(R.id.address_textView);
                view.setText(address);
            } else {
                String error = bluetoothAdapterDto.getError();
                TextView view = findViewById(R.id.error_textView);
                view.setText(error);
            }
        }
    }
}
