package a5.com.a5bluetoothlibrary;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.util.Log;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* compiled from: A5BluetoothUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020 J\u001e\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006("}, d2 = {"La5/com/a5bluetoothlibrary/A5BluetoothUtils;", "", "()V", "CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID", "Ljava/util/UUID;", "INITIAL_MESSAGE_TYPE", "", "INITIAL_REPLY", "ISOMETRIC_MESSAGE_TYPE", "ONE_SECOND", "", "READ_UUID", "getREAD_UUID", "()Ljava/util/UUID;", "SEARCH_TIMEOUT", "SERVICE_UUID", "getSERVICE_UUID", "START_ISOMETRIC_COMMAND", "STOP_COMMAND", "STOP_COMMAND_TIMER", "TAG", "getTAG", "()Ljava/lang/String;", "TARE_COMMAND", "UNKNOWN_MESSAGE_TYPE", "WRITE_UUID", "getWRITE_UUID", "internalEnableNotifications", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "sendCommand", "command", "bluetoothGatt", "writeChar", "setInitialReply", "", "message", "a5bluetoothlibrary_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class A5BluetoothUtils {
    private static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID;
    public static final String INITIAL_MESSAGE_TYPE = "initial";
    public static final String INITIAL_REPLY = "TVGTIME";
    public static final String ISOMETRIC_MESSAGE_TYPE = "isometric";
    public static final long ONE_SECOND = 1000;
    private static final UUID READ_UUID;
    public static final long SEARCH_TIMEOUT = 30000;
    private static final UUID SERVICE_UUID;
    public static final String START_ISOMETRIC_COMMAND = "ISOM!";
    public static final String STOP_COMMAND = "STOP!";
    public static final long STOP_COMMAND_TIMER = 300000;
    public static final String TARE_COMMAND = "TARE!";
    public static final String UNKNOWN_MESSAGE_TYPE = "unknown";
    private static final UUID WRITE_UUID;
    public static final A5BluetoothUtils INSTANCE = new A5BluetoothUtils();
    private static final String TAG = TAG;
    private static final String TAG = TAG;

    static {
        UUID fromString = UUID.fromString("00005000-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkExpressionValueIsNotNull(fromString, "UUID.fromString(\"0000500…-1000-8000-00805f9b34fb\")");
        SERVICE_UUID = fromString;
        UUID fromString2 = UUID.fromString("00005a02-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkExpressionValueIsNotNull(fromString2, "UUID.fromString(\"00005a0…-1000-8000-00805f9b34fb\")");
        WRITE_UUID = fromString2;
        UUID fromString3 = UUID.fromString("00005a01-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkExpressionValueIsNotNull(fromString3, "UUID.fromString(\"00005a0…-1000-8000-00805f9b34fb\")");
        READ_UUID = fromString3;
        UUID fromString4 = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkExpressionValueIsNotNull(fromString4, "UUID.fromString(\"0000290…-1000-8000-00805f9b34fb\")");
        CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = fromString4;
    }

    private A5BluetoothUtils() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final UUID getSERVICE_UUID() {
        return SERVICE_UUID;
    }

    public final UUID getWRITE_UUID() {
        return WRITE_UUID;
    }

    public final UUID getREAD_UUID() {
        return READ_UUID;
    }

    public final void sendCommand(String command, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic writeChar) {
        Intrinsics.checkParameterIsNotNull(command, "command");
        Intrinsics.checkParameterIsNotNull(bluetoothGatt, "bluetoothGatt");
        Intrinsics.checkParameterIsNotNull(writeChar, "writeChar");
        try {
            byte[] bytes = command.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            if (bytes == null) {
                Intrinsics.throwNpe();
            }
            byte[] bArr = new byte[bytes.length + 2];
            bArr[0] = 65;
            int length = bytes.length;
            if (1 <= length) {
                int i = 1;
                while (true) {
                    bArr[i] = bytes[i - 1];
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            bArr[bytes.length + 1] = 25;
            writeChar.setValue(bArr);
            bluetoothGatt.writeCharacteristic(writeChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean setInitialReply(BluetoothGatt gatt, BluetoothGattCharacteristic writeChar, String message) {
        Intrinsics.checkParameterIsNotNull(gatt, "gatt");
        Intrinsics.checkParameterIsNotNull(writeChar, "writeChar");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.v(TAG, "setInitialReply ");
        writeChar.setValue(message);
        return gatt.writeCharacteristic(writeChar);
    }

    public final void internalEnableNotifications(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        Intrinsics.checkParameterIsNotNull(gatt, "gatt");
        Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
        if ((characteristic.getProperties() & 16) == 0) {
            return;
        }
        String str = TAG;
        Log.d(str, "gatt.setCharacteristicNotification(" + characteristic.getUuid() + ", true)");
        gatt.setCharacteristicNotification(characteristic, true);
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
        if (descriptor != null) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            String str2 = TAG;
            Log.v(str2, "Enabling notifications for " + characteristic.getUuid());
            String str3 = TAG;
            Log.d(str3, "gatt.writeDescriptor(" + INSTANCE + ".Const.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID, value=0x01-00)");
            gatt.writeDescriptor(descriptor);
        }
    }
}
