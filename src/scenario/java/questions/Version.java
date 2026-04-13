package scenario.java.questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version implements Comparable<Version> {
    private static final String ERROR_VERSION_NULL = "'version' must not be null!";
    private static final String ERROR_OTHER_NULL = "'other' must not be null!";
    private static final String ERROR_PATTERN = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    private static final Pattern PATTERN = Pattern.compile("^(\\d+)(\\.(\\d+))?(\\.(\\d+))?(-SNAPSHOT)?$");

    private final int major;
    private final int minor;
    private final int patch;
    private final boolean snapshot;

    public Version(String version) {
        if (version == null) {
            throw new IllegalArgumentException(ERROR_VERSION_NULL);
        }

        Matcher matcher = PATTERN.matcher(version);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_PATTERN);
        }

        try {
            this.major = Integer.parseInt(matcher.group(1));
            this.minor = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;
            this.patch = matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 0;
            this.snapshot = matcher.group(6) != null;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PATTERN);
        }
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    @Override
    public int compareTo(Version other) {

        if (other == null) {
            throw new IllegalArgumentException(ERROR_OTHER_NULL);
        }

        if (this.major != other.major) {
            return Integer.compare(this.major, other.major);
        }

        if (this.minor != other.minor) {
            return Integer.compare(this.minor, other.minor);
        }

        if (this.patch != other.patch) {
            return Integer.compare(this.patch, other.patch);
        }

        // Snapshot logic
        if (this.snapshot && !other.snapshot) return -1;
        if (!this.snapshot && other.snapshot) return 1;

        return 0;
    }
}