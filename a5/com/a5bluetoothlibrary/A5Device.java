package a5.com.a5bluetoothlibrary;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: A5Device.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006\u001d"}, d2 = {"La5/com/a5bluetoothlibrary/A5Device;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "deviceFirmware", "", "protocolVersion", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "setDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "getDeviceFirmware", "()Ljava/lang/String;", "setDeviceFirmware", "(Ljava/lang/String;)V", "evergreenMode", "", "getEvergreenMode", "()Z", "setEvergreenMode", "(Z)V", "getProtocolVersion", "setProtocolVersion", "disconnect", "", "startIsometric", "stop", "tare", "a5bluetoothlibrary_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class A5Device {
    private BluetoothDevice device;
    private String deviceFirmware;
    private boolean evergreenMode;
    private String protocolVersion;

    public A5Device(BluetoothDevice device, String deviceFirmware, String protocolVersion) {
        Intrinsics.checkParameterIsNotNull(device, "device");
        Intrinsics.checkParameterIsNotNull(deviceFirmware, "deviceFirmware");
        Intrinsics.checkParameterIsNotNull(protocolVersion, "protocolVersion");
        this.device = device;
        this.deviceFirmware = deviceFirmware;
        this.protocolVersion = protocolVersion;
    }

    public /* synthetic */ A5Device(BluetoothDevice bluetoothDevice, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bluetoothDevice, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final String getDeviceFirmware() {
        return this.deviceFirmware;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final void setDevice(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "<set-?>");
        this.device = bluetoothDevice;
    }

    public final void setDeviceFirmware(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.deviceFirmware = str;
    }

    public final void setProtocolVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.protocolVersion = str;
    }

    public final boolean getEvergreenMode() {
        return this.evergreenMode;
    }

    public final void setEvergreenMode(boolean z) {
        this.evergreenMode = z;
    }

    public final void startIsometric() {
        A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
        String address = this.device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
        a5DeviceManager.startIsometric$a5bluetoothlibrary_release(address);
    }

    public final void tare() {
        A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
        String address = this.device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
        a5DeviceManager.sendCommand$a5bluetoothlibrary_release(address, A5BluetoothUtils.TARE_COMMAND);
    }

    public final void stop() {
        A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
        String address = this.device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
        a5DeviceManager.stop$a5bluetoothlibrary_release(address);
    }

    public final void disconnect() {
        A5DeviceManager a5DeviceManager = A5DeviceManager.INSTANCE;
        String address = this.device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
        a5DeviceManager.disconnect$a5bluetoothlibrary_release(address);
    }
}
