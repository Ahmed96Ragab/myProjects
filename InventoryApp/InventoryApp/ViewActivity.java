package com.inventory.ragab.InventoryApp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.ragab.InventoryApp.data.InventoryContract;


@SuppressLint("Registered")
public class ViewActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_INVENTORY_LOADER = 0;
    private Uri mCurrentProductUri;

    private TextView mProductNameViewText;
    private TextView mProductPriceViewText;
    private TextView mProductQuantityViewText;
    private TextView mProductSupplieNameSpinner;
    private TextView mProductSupplierPhoneNumberViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mProductNameViewText = (TextView) findViewById(R.id.product_name_view_text);
        mProductPriceViewText = (TextView) findViewById(R.id.product_price_view_text);
        mProductQuantityViewText = (TextView) findViewById(R.id.product_quantity_view_text);
        mProductSupplieNameSpinner = (TextView) findViewById(R.id.product_supplier_name_view_text);
        mProductSupplierPhoneNumberViewText = (TextView) findViewById(R.id.product_supplier_phone_number_view_text);

        Intent intent = getIntent();
        mCurrentProductUri = intent.getData();
        if (mCurrentProductUri == null) {
            invalidateOptionsMenu();
        } else {
            getLoaderManager().initLoader(EXISTING_INVENTORY_LOADER, null, this);
        }

        Log.d("message", "onCreate ViewActivity");

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITY,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER
        };
        return new CursorLoader(this,
                mCurrentProductUri,
                projection,
                null,
                null,
                null);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }
        if (cursor.moveToFirst()) {

            final int idColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER);

            String currentName = cursor.getString(nameColumnIndex);
            final int currentPrice = cursor.getInt(priceColumnIndex);
            final int currentQuantity = cursor.getInt(quantityColumnIndex);
            int currentSupplierName = cursor.getInt(supplierNameColumnIndex);
            final String currentSupplierPhone = cursor.getString(supplierPhoneColumnIndex);

            mProductNameViewText.setText(currentName);
            mProductPriceViewText.setText(Integer.toString(currentPrice));
            mProductQuantityViewText.setText(Integer.toString(currentQuantity));
            mProductSupplierPhoneNumberViewText.setText(currentSupplierPhone);


            switch (currentSupplierName) {
                case InventoryContract.InventoryEntry.SUPPLIER_AMAZON:
                    mProductSupplieNameSpinner.setText(getText(R.string.supplier_amazon));
                    break;
                case InventoryContract.InventoryEntry.SUPPLIER_ALI:
                    mProductSupplieNameSpinner.setText(getText(R.string.supplier_ali));
                    break;
                case InventoryContract.InventoryEntry.SUPPLIER_OBEIKAN:
                    mProductSupplieNameSpinner.setText(getText(R.string.supplier_obeikan));
                    break;
                default:
                    mProductSupplieNameSpinner.setText(getText(R.string.supplier_unknown));
                    break;
            }

            Button productDecreaseButton = (Button) findViewById(R.id.decrease_button);
            productDecreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseCount(idColumnIndex, currentQuantity);
                }
            });

            Button productIncreaseButton = (Button) findViewById(R.id.increase_button);
            productIncreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseCount(idColumnIndex, currentQuantity);
                }
            });

            Button productDeleteButton = (Button) findViewById(R.id.delete_button);
            productDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDeleteConfirmationDialog();
                }
            });

            Button phoneButton = (Button) findViewById(R.id.phone_button);
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone = String.valueOf(currentSupplierPhone);
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void decreaseCount(int productID, int productQuantity) {
        productQuantity = productQuantity - 1;
        if (productQuantity >= 0) {
            updateProduct(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_change_msg), Toast.LENGTH_SHORT).show();

            Log.d("Log msg", " - productID " + productID + " - quantity " + productQuantity + " , decreaseCount has been called.");
        } else {
            Toast.makeText(this, getString(R.string.quantity_finish_msg), Toast.LENGTH_SHORT).show();
        }
    }

    public void increaseCount(int productID, int productQuantity) {
        productQuantity = productQuantity + 1;
        if (productQuantity >= 0) {
            updateProduct(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_change_msg), Toast.LENGTH_SHORT).show();

            Log.d("Log msg", " - productID " + productID + " - quantity " + productQuantity + " , decreaseCount has been called.");
        }
    }


    private void updateProduct(int productQuantity) {
        Log.d("message", "updateProduct at ViewActivity");

        if (mCurrentProductUri == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITY, productQuantity);

        if (mCurrentProductUri == null) {
            Uri newUri = getContentResolver().insert(InventoryContract.InventoryEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, getString(R.string.insert_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.insert_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            int rowsAffected = getContentResolver().update(mCurrentProductUri, values, null, null);
            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.update_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.insert_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteProduct() {
        if (mCurrentProductUri != null) {
            int rowsDeleted = getContentResolver().delete(mCurrentProductUri, null, null);
            if (rowsDeleted == 0) {
                Toast.makeText(this, getString(R.string.delete_product_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.delete_product_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteProduct();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
