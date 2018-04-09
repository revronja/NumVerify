
public final class Config_HasNoKey {
		public String NumVerifyAPIKey;
		public static Config configInstance = null;
		
	    public Config_HasNoKey() {
	    // api key goes into this empty string 
	    	NumVerifyAPIKey = "";
	    }
	    public static Config getConfigInstance() {
	        if (configInstance == null) {
	            synchronized (Config.class) {
	                if (configInstance == null) {
	                    configInstance = new Config();
	                }
	            }
	        }
	        return configInstance;
	    }
	    public String getNumVerifyAPIKey() {
	        return NumVerifyAPIKey;
	    }

	    public void setNumVerifyAPIKey(String NumVerifyAPIKey) {
	        this.NumVerifyAPIKey = NumVerifyAPIKey;
	    }

	   
	    
	}

