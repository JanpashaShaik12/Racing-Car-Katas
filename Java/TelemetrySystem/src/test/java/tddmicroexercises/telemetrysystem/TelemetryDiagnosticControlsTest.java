package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TelemetryDiagnosticControlsTest
{
    ConnectionImpl connectionImpl = new ConnectionImpl();
    ClientImpl clientClass = new ClientImpl();
    TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(clientClass, connectionImpl);
	@Test
    void checkTransmission() {
        try {
            if(clientClass.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
            telemetryDiagnosticControls.checkTransmission();
            Assert.assertEquals(false, clientClass.getOnlineStatus());

        } catch (Exception e) {
            Assert.assertNotEquals("Unknown exception", e);
        }
    }
    @Test
    void checkSetDiagnostic(){
        telemetryDiagnosticControls.setDiagnosticInfo("abc");
        Assert.assertEquals("abc",telemetryDiagnosticControls.getDiagnosticInfo());
    }
}
