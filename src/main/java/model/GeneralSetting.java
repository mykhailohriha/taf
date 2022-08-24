package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralSetting {
    String launchInactivityTimeout;
    String keepLaunches;
    String keepLogs;
    String keepAttachments;
}
