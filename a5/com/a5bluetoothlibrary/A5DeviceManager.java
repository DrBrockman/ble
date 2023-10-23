package a5.com.a5bluetoothlibrary;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: A5DeviceManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b *\u0001\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\rH\u0002J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0006\u0010.\u001a\u00020\u001eJ\u0006\u0010/\u001a\u00020\u001eJ\u001d\u00100\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0000¢\u0006\u0002\b2J\u000e\u00103\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u00104\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\rH\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\rH\u0002J\u0015\u00108\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0002\b9J\b\u0010:\u001a\u00020\u001eH\u0002J\u0015\u0010;\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020\u001eH\u0002J\u0015\u0010>\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0002\b?R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"La5/com/a5bluetoothlibrary/A5DeviceManager;", "", "()V", "a5BluetoothCallback", "La5/com/a5bluetoothlibrary/A5BluetoothCallback;", "a5Device", "La5/com/a5bluetoothlibrary/A5Device;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "connectedDeviceMap", "", "", "Landroid/bluetooth/BluetoothGatt;", "countDownTimer", "Landroid/os/CountDownTimer;", "currentPressure", "", "gattCallback", "a5/com/a5bluetoothlibrary/A5DeviceManager$gattCallback$1", "La5/com/a5bluetoothlibrary/A5DeviceManager$gattCallback$1;", "isDisconnected", "", "leScanCallback", "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "protocolVersion", "scannedDevices", "Ljava/util/ArrayList;", "connect", "", "context", "Landroid/content/Context;", "device", "disconnect", "address", "disconnect$a5bluetoothlibrary_release", "getDeviceFirmware", "getProtocolVersion", "initializeDeviceManager", "isDeviceConnected", "onGattSuccess", "gatt", "onStateConnected", "onStateDisconnected", "status", "removeCallback", "scanForDevices", "sendCommand", "command", "sendCommand$a5bluetoothlibrary_release", "setCallback", "setInitialReply", "message", "setProtocolVersionAndDeviceName", "getMessageFromBytes", "startIsometric", "startIsometric$a5bluetoothlibrary_release", "startTimer", "stop", "stop$a5bluetoothlibrary_release", "stopTimer", "tare", "tare$a5bluetoothlibrary_release", "a5bluetoothlibrary_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class A5DeviceManager {
    private static A5BluetoothCallback a5BluetoothCallback;
    private static A5Device a5Device;
    private static BluetoothAdapter bluetoothAdapter;
    private static BluetoothManager bluetoothManager;
    private static CountDownTimer countDownTimer;
    private static int currentPressure;
    private static String protocolVersion;
    public static final A5DeviceManager INSTANCE = new A5DeviceManager();
    private static Map<String, BluetoothGatt> connectedDeviceMap = new HashMap();
    private static ArrayList<String> scannedDevices = new ArrayList<>();
    private static boolean isDisconnected = true;
    private static final BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: a5.com.a5bluetoothlibrary.A5DeviceManager$leScanCallback$1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice device, int i, byte[] bArr) {
            ArrayList arrayList;
            ArrayList arrayList2;
            A5BluetoothCallback a5BluetoothCallback2;
            Log.d(A5BluetoothUtils.INSTANCE.getTAG(), "device discovered");
            Intrinsics.checkExpressionValueIsNotNull(device, "device");
            if (device.getName() != null) {
                A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
                arrayList = A5DeviceManager.scannedDevices;
                if (arrayList.contains(device.getName())) {
                    return;
                }
                String name = device.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "device.name");
                if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "TAO", false, 2, (Object) null)) {
                    String name2 = device.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name2, "device.name");
                    if (!StringsKt.contains$default((CharSequence) name2, (CharSequence) "ACTIV", false, 2, (Object) null)) {
                        return;
                    }
                }
                A5DeviceManager a5DeviceManager2 = A5DeviceManager.INSTANCE;
                arrayList2 = A5DeviceManager.scannedDevices;
                arrayList2.add(device.getName());
                A5DeviceManager a5DeviceManager3 = A5DeviceManager.INSTANCE;
                a5BluetoothCallback2 = A5DeviceManager.a5BluetoothCallback;
                if (a5BluetoothCallback2 != null) {
                    a5BluetoothCallback2.deviceFound(new A5Device(device, null, null, 6, null));
                }
            }
        }
    };
    private static final A5DeviceManager$gattCallback$1 gattCallback = new BluetoothGattCallback() { // from class: a5.com.a5bluetoothlibrary.A5DeviceManager$gattCallback$1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                if (bluetoothGatt != null) {
                    A5DeviceManager.INSTANCE.onStateConnected(bluetoothGatt);
                }
            } else if (i2 != 0 || bluetoothGatt == null) {
            } else {
                A5DeviceManager.INSTANCE.onStateDisconnected(bluetoothGatt, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            if (i != 0 || bluetoothGatt == null) {
                return;
            }
            A5DeviceManager.INSTANCE.onGattSuccess(bluetoothGatt);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
            String deviceFirmware;
            String protocolVersion2;
            A5BluetoothCallback a5BluetoothCallback2;
            A5BluetoothCallback a5BluetoothCallback3;
            Intrinsics.checkParameterIsNotNull(gatt, "gatt");
            Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
            super.onCharacteristicWrite(gatt, characteristic, i);
            byte[] value = characteristic.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "characteristic.value");
            String str = new String(value, Charsets.UTF_8);
            if (i == 0) {
                String tag = A5BluetoothUtils.INSTANCE.getTAG();
                Log.d(tag, "OnCharacteristicWrite GATT_SUCCESS " + characteristic.getValue());
                BluetoothDevice device = gatt.getDevice();
                if ((device != null ? device.getAddress() : null) != null) {
                    BluetoothDevice device2 = gatt.getDevice();
                    Intrinsics.checkExpressionValueIsNotNull(device2, "gatt.device");
                    deviceFirmware = A5DeviceManager.INSTANCE.getDeviceFirmware();
                    protocolVersion2 = A5DeviceManager.INSTANCE.getProtocolVersion();
                    A5Device a5Device2 = new A5Device(device2, deviceFirmware, protocolVersion2);
                    A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
                    A5DeviceManager.a5Device = a5Device2;
                    A5DeviceManager a5DeviceManager2 = A5DeviceManager.INSTANCE;
                    a5BluetoothCallback2 = A5DeviceManager.a5BluetoothCallback;
                    if (a5BluetoothCallback2 != null) {
                        a5BluetoothCallback2.onWriteCompleted(a5Device2, str);
                    }
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) A5BluetoothUtils.INITIAL_REPLY, false, 2, (Object) null)) {
                        A5DeviceManager a5DeviceManager3 = A5DeviceManager.INSTANCE;
                        a5BluetoothCallback3 = A5DeviceManager.a5BluetoothCallback;
                        if (a5BluetoothCallback3 != null) {
                            a5BluetoothCallback3.deviceConnected(a5Device2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String tag2 = A5BluetoothUtils.INSTANCE.getTAG();
            Log.e(tag2, "OnCharacteristicWrite GATT_ERROR " + characteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
            Intrinsics.checkParameterIsNotNull(gatt, "gatt");
            Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
            super.onCharacteristicRead(gatt, characteristic, i);
            if (i == 0) {
                String tag = A5BluetoothUtils.INSTANCE.getTAG();
                Log.d(tag, "onCharacteristicRead GATT_SUCCESS " + characteristic.getValue());
                return;
            }
            String tag2 = A5BluetoothUtils.INSTANCE.getTAG();
            Log.e(tag2, "onCharacteristicRead GATT_ERROR " + characteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String str;
            A5Device a5Device2;
            A5Device a5Device3;
            A5BluetoothCallback a5BluetoothCallback2;
            String deviceFirmware;
            String protocolVersion2;
            BluetoothDevice device;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
            if (value != null) {
                String str2 = new String(value, Charsets.UTF_8);
                String address = (bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null) ? null : device.getAddress();
                BluetoothDevice device2 = bluetoothGatt != null ? bluetoothGatt.getDevice() : null;
                if (device2 != null) {
                    A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
                    deviceFirmware = A5DeviceManager.INSTANCE.getDeviceFirmware();
                    protocolVersion2 = A5DeviceManager.INSTANCE.getProtocolVersion();
                    A5DeviceManager.a5Device = new A5Device(device2, deviceFirmware, protocolVersion2);
                }
                String str3 = str2;
                int i = 0;
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "TC5k", false, 2, (Object) null)) {
                    if (bluetoothGatt != null && address != null) {
                        A5DeviceManager.INSTANCE.sendCommand$a5bluetoothlibrary_release(address, A5BluetoothUtils.INITIAL_REPLY);
                    }
                    A5DeviceManager.INSTANCE.setProtocolVersionAndDeviceName(str2);
                    str = A5BluetoothUtils.INITIAL_MESSAGE_TYPE;
                } else if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "IS", false, 2, (Object) null)) {
                    i = Integer.parseInt((String) StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) str3, new String[]{"/"}, false, 0, 6, (Object) null).get(0), new String[]{ExifInterface.LATITUDE_SOUTH}, false, 0, 6, (Object) null).get(1));
                    str = A5BluetoothUtils.ISOMETRIC_MESSAGE_TYPE;
                } else {
                    str = "unknown";
                }
                BluetoothDevice device3 = bluetoothGatt != null ? bluetoothGatt.getDevice() : null;
                if (device3 != null) {
                    A5DeviceManager a5DeviceManager2 = A5DeviceManager.INSTANCE;
                    a5Device2 = A5DeviceManager.a5Device;
                    if (a5Device2 != null) {
                        a5Device2.setDevice(device3);
                    }
                    A5DeviceManager a5DeviceManager3 = A5DeviceManager.INSTANCE;
                    a5Device3 = A5DeviceManager.a5Device;
                    if (a5Device3 == null || !Intrinsics.areEqual(str, A5BluetoothUtils.ISOMETRIC_MESSAGE_TYPE)) {
                        return;
                    }
                    A5DeviceManager a5DeviceManager4 = A5DeviceManager.INSTANCE;
                    A5DeviceManager.currentPressure = i;
                    A5DeviceManager a5DeviceManager5 = A5DeviceManager.INSTANCE;
                    a5BluetoothCallback2 = A5DeviceManager.a5BluetoothCallback;
                    if (a5BluetoothCallback2 != null) {
                        a5BluetoothCallback2.didReceiveIsometric(a5Device3, i);
                    }
                }
            }
        }
    };

    private A5DeviceManager() {
    }

    public static final /* synthetic */ BluetoothAdapter access$getBluetoothAdapter$p(A5DeviceManager a5DeviceManager) {
        BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
        if (bluetoothAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothAdapter");
        }
        return bluetoothAdapter2;
    }

    public final void initializeDeviceManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("bluetooth");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        }
        BluetoothManager bluetoothManager2 = (BluetoothManager) systemService;
        bluetoothManager = bluetoothManager2;
        if (bluetoothManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothManager");
        }
        BluetoothAdapter adapter = bluetoothManager2.getAdapter();
        Intrinsics.checkExpressionValueIsNotNull(adapter, "bluetoothManager.adapter");
        bluetoothAdapter = adapter;
    }

    public final synchronized void connect(Context context, A5Device device) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(device, "device");
        if (isDisconnected) {
            isDisconnected = false;
            device.getDevice().connectGatt(context, false, gattCallback);
        }
    }

    public final void setCallback(A5BluetoothCallback a5BluetoothCallback2) {
        Intrinsics.checkParameterIsNotNull(a5BluetoothCallback2, "a5BluetoothCallback");
        a5BluetoothCallback = a5BluetoothCallback2;
    }

    public final void removeCallback() {
        a5BluetoothCallback = null;
    }

    public final void scanForDevices() {
        BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
        if (bluetoothAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothAdapter");
        }
        if (!bluetoothAdapter2.isEnabled()) {
            A5BluetoothCallback a5BluetoothCallback2 = a5BluetoothCallback;
            if (a5BluetoothCallback2 != null) {
                a5BluetoothCallback2.bluetoothIsSwitchedOff();
                return;
            }
            return;
        }
        scannedDevices.clear();
        BluetoothAdapter bluetoothAdapter3 = bluetoothAdapter;
        if (bluetoothAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothAdapter");
        }
        bluetoothAdapter3.startLeScan(leScanCallback);
        new Handler().postDelayed(new Runnable() { // from class: a5.com.a5bluetoothlibrary.A5DeviceManager$scanForDevices$1
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothAdapter.LeScanCallback leScanCallback2;
                A5BluetoothCallback a5BluetoothCallback3;
                BluetoothAdapter access$getBluetoothAdapter$p = A5DeviceManager.access$getBluetoothAdapter$p(A5DeviceManager.INSTANCE);
                A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
                leScanCallback2 = A5DeviceManager.leScanCallback;
                access$getBluetoothAdapter$p.stopLeScan(leScanCallback2);
                A5DeviceManager a5DeviceManager2 = A5DeviceManager.INSTANCE;
                a5BluetoothCallback3 = A5DeviceManager.a5BluetoothCallback;
                if (a5BluetoothCallback3 != null) {
                    a5BluetoothCallback3.searchCompleted();
                }
            }
        }, A5BluetoothUtils.SEARCH_TIMEOUT);
    }

    public final boolean isDeviceConnected(A5Device device) {
        Intrinsics.checkParameterIsNotNull(device, "device");
        BluetoothManager bluetoothManager2 = bluetoothManager;
        if (bluetoothManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothManager");
        }
        return bluetoothManager2.getConnectionState(device.getDevice(), 7) == 2;
    }

    public final void disconnect$a5bluetoothlibrary_release(String address) {
        A5BluetoothCallback a5BluetoothCallback2;
        Intrinsics.checkParameterIsNotNull(address, "address");
        if (connectedDeviceMap.containsKey(address)) {
            isDisconnected = true;
            BluetoothGatt bluetoothGatt = connectedDeviceMap.get(address);
            if (bluetoothGatt != null) {
                bluetoothGatt.close();
            }
            A5Device a5Device2 = a5Device;
            if (a5Device2 == null || (a5BluetoothCallback2 = a5BluetoothCallback) == null) {
                return;
            }
            a5BluetoothCallback2.deviceDisconnected(a5Device2);
        }
    }

    public final void stop$a5bluetoothlibrary_release(String address) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        Intrinsics.checkParameterIsNotNull(address, "address");
        if (!connectedDeviceMap.containsKey(address) || (bluetoothGatt = connectedDeviceMap.get(address)) == null || (service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID())) == null) {
            return;
        }
        BluetoothGattCharacteristic writeChar = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getWRITE_UUID());
        A5BluetoothUtils a5BluetoothUtils = A5BluetoothUtils.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(writeChar, "writeChar");
        a5BluetoothUtils.sendCommand(A5BluetoothUtils.STOP_COMMAND, bluetoothGatt, writeChar);
        A5Device a5Device2 = a5Device;
        if (a5Device2 == null || !a5Device2.getEvergreenMode()) {
            return;
        }
        startTimer();
    }

    public final void startIsometric$a5bluetoothlibrary_release(String address) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        Intrinsics.checkParameterIsNotNull(address, "address");
        if (!connectedDeviceMap.containsKey(address) || (bluetoothGatt = connectedDeviceMap.get(address)) == null || (service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID())) == null) {
            return;
        }
        BluetoothGattCharacteristic writeChar = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getWRITE_UUID());
        A5BluetoothUtils a5BluetoothUtils = A5BluetoothUtils.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(writeChar, "writeChar");
        a5BluetoothUtils.sendCommand(A5BluetoothUtils.START_ISOMETRIC_COMMAND, bluetoothGatt, writeChar);
    }

    public final void tare$a5bluetoothlibrary_release(String address) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        Intrinsics.checkParameterIsNotNull(address, "address");
        if (!connectedDeviceMap.containsKey(address) || (bluetoothGatt = connectedDeviceMap.get(address)) == null || (service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID())) == null) {
            return;
        }
        BluetoothGattCharacteristic writeChar = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getWRITE_UUID());
        A5BluetoothUtils a5BluetoothUtils = A5BluetoothUtils.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(writeChar, "writeChar");
        a5BluetoothUtils.sendCommand(A5BluetoothUtils.TARE_COMMAND, bluetoothGatt, writeChar);
    }

    public final void sendCommand$a5bluetoothlibrary_release(String address, String command) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.checkParameterIsNotNull(address, "address");
        Intrinsics.checkParameterIsNotNull(command, "command");
        if (!connectedDeviceMap.containsKey(address) || (bluetoothGatt = connectedDeviceMap.get(address)) == null) {
            return;
        }
        stopTimer();
        BluetoothGattService service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID());
        if (service != null) {
            BluetoothGattCharacteristic writeChar = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getWRITE_UUID());
            A5BluetoothUtils a5BluetoothUtils = A5BluetoothUtils.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(writeChar, "writeChar");
            a5BluetoothUtils.sendCommand(command, bluetoothGatt, writeChar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStateConnected(BluetoothGatt bluetoothGatt) {
        Map<String, BluetoothGatt> map = connectedDeviceMap;
        BluetoothDevice device = bluetoothGatt.getDevice();
        Intrinsics.checkExpressionValueIsNotNull(device, "gatt.device");
        String address = device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "gatt.device.address");
        map.put(address, bluetoothGatt);
        Log.v(A5BluetoothUtils.INSTANCE.getTAG(), "Discovering Services...");
        Log.d(A5BluetoothUtils.INSTANCE.getTAG(), "gatt.discoverServices()");
        bluetoothGatt.discoverServices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStateDisconnected(BluetoothGatt bluetoothGatt, int i) {
        BluetoothDevice device = bluetoothGatt.getDevice();
        Intrinsics.checkExpressionValueIsNotNull(device, "gatt.device");
        String address = device.getAddress();
        if (connectedDeviceMap.containsKey(address)) {
            BluetoothGatt bluetoothGatt2 = connectedDeviceMap.get(address);
            if (bluetoothGatt2 != null) {
                bluetoothGatt2.close();
            }
            connectedDeviceMap.remove(address);
        }
        isDisconnected = true;
        A5Device a5Device2 = a5Device;
        if (a5Device2 != null) {
            BluetoothDevice device2 = bluetoothGatt.getDevice();
            Intrinsics.checkExpressionValueIsNotNull(device2, "gatt.device");
            a5Device2.setDevice(device2);
        }
        A5Device a5Device3 = a5Device;
        if (a5Device3 != null) {
            if (i == 133) {
                A5BluetoothCallback a5BluetoothCallback2 = a5BluetoothCallback;
                if (a5BluetoothCallback2 != null) {
                    a5BluetoothCallback2.deviceDisconnected133Status(a5Device3);
                    return;
                }
                return;
            }
            A5BluetoothCallback a5BluetoothCallback3 = a5BluetoothCallback;
            if (a5BluetoothCallback3 != null) {
                a5BluetoothCallback3.deviceDisconnected(a5Device3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGattSuccess(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID());
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getREAD_UUID());
            Intrinsics.checkExpressionValueIsNotNull(characteristic, "bluetoothGattService.get…BluetoothUtils.READ_UUID)");
            A5BluetoothUtils.INSTANCE.internalEnableNotifications(bluetoothGatt, characteristic);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProtocolVersionAndDeviceName(String str) {
        List emptyList;
        boolean z;
        List<String> split = new Regex(";").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            A5Device a5Device2 = a5Device;
            if (a5Device2 != null) {
                a5Device2.setProtocolVersion(strArr[2]);
            }
            A5Device a5Device3 = a5Device;
            if (a5Device3 != null) {
                a5Device3.setDeviceFirmware(strArr[1]);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final boolean setInitialReply(BluetoothGatt bluetoothGatt, String str) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(A5BluetoothUtils.INSTANCE.getSERVICE_UUID());
        if (service == null || (characteristic = service.getCharacteristic(A5BluetoothUtils.INSTANCE.getWRITE_UUID())) == null) {
            return false;
        }
        A5BluetoothUtils.INSTANCE.setInitialReply(bluetoothGatt, characteristic, str);
        return false;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [a5.com.a5bluetoothlibrary.A5DeviceManager$startTimer$1] */
    private final void startTimer() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        countDownTimer = new CountDownTimer(A5BluetoothUtils.STOP_COMMAND_TIMER, 1000L) { // from class: a5.com.a5bluetoothlibrary.A5DeviceManager$startTimer$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                Ref.IntRef.this.element++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                A5Device a5Device2;
                A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
                a5Device2 = A5DeviceManager.a5Device;
                if (a5Device2 != null) {
                    A5DeviceManager a5DeviceManager2 = A5DeviceManager.INSTANCE;
                    String address = a5Device2.getDevice().getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address, "a5Device.device.address");
                    a5DeviceManager2.sendCommand$a5bluetoothlibrary_release(address, A5BluetoothUtils.START_ISOMETRIC_COMMAND);
                    A5DeviceManager a5DeviceManager3 = A5DeviceManager.INSTANCE;
                    String address2 = a5Device2.getDevice().getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address2, "a5Device.device.address");
                    a5DeviceManager3.stop$a5bluetoothlibrary_release(address2);
                }
            }
        }.start();
    }

    private final void stopTimer() {
        CountDownTimer countDownTimer2 = countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDeviceFirmware() {
        String deviceFirmware;
        A5Device a5Device2 = a5Device;
        return (a5Device2 == null || (deviceFirmware = a5Device2.getDeviceFirmware()) == null) ? "" : deviceFirmware;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProtocolVersion() {
        String protocolVersion2;
        A5Device a5Device2 = a5Device;
        return (a5Device2 == null || (protocolVersion2 = a5Device2.getProtocolVersion()) == null) ? "" : protocolVersion2;
    }
}
