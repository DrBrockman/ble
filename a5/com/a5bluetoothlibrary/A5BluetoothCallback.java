package a5.com.a5bluetoothlibrary;

import kotlin.Metadata;
/* compiled from: A5BluetoothCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"La5/com/a5bluetoothlibrary/A5BluetoothCallback;", "", "bluetoothIsSwitchedOff", "", "deviceConnected", "device", "La5/com/a5bluetoothlibrary/A5Device;", "deviceDisconnected", "deviceDisconnected133Status", "deviceFound", "didReceiveIsometric", "value", "", "onWriteCompleted", "", "searchCompleted", "a5bluetoothlibrary_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public interface A5BluetoothCallback {
    void bluetoothIsSwitchedOff();

    void deviceConnected(A5Device a5Device);

    void deviceDisconnected(A5Device a5Device);

    void deviceDisconnected133Status(A5Device a5Device);

    void deviceFound(A5Device a5Device);

    void didReceiveIsometric(A5Device a5Device, int i);

    void onWriteCompleted(A5Device a5Device, String str);

    void searchCompleted();
}
