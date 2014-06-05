package starter;

import oneconnexsysadminarea.SysadminLoginpage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {

	public void run(){
		SysadminLoginpage sysadminlogin = new SysadminLoginpage();
//		sysadminlogin.loginpageIsShownWithLoginButtonAndLoginTextField();
	}
}
