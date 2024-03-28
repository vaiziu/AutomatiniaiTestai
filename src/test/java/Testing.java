import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Testing {
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder email = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            email.append(randomChar);
        }

        // Adding '@' symbol
        email.append("@");

        // Selecting random domain
        String randomDomain = domains[random.nextInt(domains.length)];
        email.append(randomDomain);

        return email.toString();
    }

    public String generateUsername() {
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder username = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            username.append(randomChar);

        }
        return username.toString();
    }

    WebDriver _globalDriver;

    @BeforeTest
    public void setUp() {
        // Launch browser and navigate to application
        _globalDriver = new ChromeDriver();

//        _globalDriver.get("https://elenta.lt/");
    }


//    testuojame ar atidaro puslapi elenta.lt

    @Test
    public void test1() {

        _globalDriver.get("https://elenta.lt/registracija");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys("traktorius");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).sendKeys("nononame@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("11*Vaida");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("11*Vaida");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement registrationText = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(registrationText.getText(), "Jūs sėkmingai prisiregistravote!");
    }

    @Test
    public void test2() {

        _globalDriver.get("https://elenta.lt/registracija");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys(generateUsername());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("11*Vaida");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("11*Vaida");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement registrationText = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(registrationText.getText(), "Jūs sėkmingai prisiregistravote!");
    }

    @Test
    public void test3() {

        _globalDriver.get("https://elenta.lt/registracija");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys(generateUsername());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("done");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("done");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement registrationText = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(registrationText.getText(), "Jūs sėkmingai prisiregistravote!");
    }

    @Test
    public void test4() {

        _globalDriver.get("https://elenta.lt/registracija");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys(""); //galiam tiesiog visa eilute istrint, jos nerasyti, bus tas pats
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("vaida123");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("vaida123");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement registrationText = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(registrationText.getText(), "Jūs sėkmingai prisiregistravote!");
    }

    @Test //testuojamas vartotojo vardas kaip speial character. turi nelesiti registruoti
    public void test5() {

        _globalDriver.get("https://elenta.lt/registracija");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys("???");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("vaida123");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("vaida123");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement registrationText = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(registrationText.getText(), "Neleidziama registruoti");
        _globalDriver.close(); //isjungia narsykles langus
    }

    @Test
    public void testAnnounce() {

        _globalDriver.get("https://elenta.lt/");
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]/p")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a[1]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.id("title")).sendKeys("asdhkajhkjahf");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/span/textarea")).sendKeys("senovinis raudonas automobilis ");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/input")).sendKeys("1300");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[4]/div/input")).sendKeys("Kaunas");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[5]/input")).sendKeys("+37067123456");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[6]/input")).sendKeys("nonameno@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[7]/input[2]")).click();
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/label/input[1]")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\Kaspis\\Downloads\\picture.png");


    }


}














