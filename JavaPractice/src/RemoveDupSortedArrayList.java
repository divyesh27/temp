import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class RemoveDupSortedArrayList {
    public static void main(String[] args) {
        
        ArrayList<Integer> inputArray = new ArrayList<>(
        //Arrays.asList(1,1,3,4,5,5,6,6,7,8));
        Arrays.asList(11,11,3,4,55,55,5,6,6,7,8));
        for(Integer i : removeDup(inputArray)) {
            System.out.println(i);
        }
    }
    
    public static List<Integer> removeDup(ArrayList<Integer> inputArray) {
        
        if(inputArray == null || inputArray.size() < 1)
            throw new IllegalArgumentException("Pass valid input");
        
        List<Integer> removeDup = new ArrayList<>();
        for(Integer i : inputArray) {
            if(!removeDup.contains(i)) {
                removeDup.add(i);
            }
        }
        Collections.sort(removeDup);
        return removeDup;
    }
}


/*
public static boolean validateDropDown(By locator) {
	
	WebElement selectDropDown = driver.findElement(By.name("DropDownlocate"));
	Select dropdown = new Select(selectDropDown);
	for(int i=0; i<10; i++) {
		String inputString = dropdown.selectByIndex(i).getText();
		if(inputString.contains("Red"))
			return true;
	}
	return false;
}
*/
