 
function isValid(){
		sName = document.getElementsByName("songName")[0].value
		artist = document.getElementsByName("artist")[0].value
 		releaseYear = document.getElementsByName("releaseYear")[0].value
 		duration = document.getElementsByName("duration")[0].value
 		form = document.getElementById("form")
		
		// Regex
		var regName =  /^[a-zA-Z0-9' -]*$/;  // Can contain letters, numbers, spaces, apostrophes, and hyphens
		var numsOnly = /^\d+$/;				 // Only numbers
		var floatCheck = /^\d+\.\d{0,2}$/;   // Float with 2 decimal spaces
		// Year ranges
		var minYear = 1860;
		var maxYear = new Date().getFullYear();
		
		// Check if fields are empty
		if(!sName || !artist || !releaseYear || !duration){
    	    alert("Make sure no fileds are empty.");
  	     	return false;
    	}
		
		// Check if the song name and artist name are valid
		// Only letters, numbers, spaces, apostrophes, and hyphens
		if(!regName.test(sName) || !regName.test(artist)){
			alert("The song name can only contain letters and numbers")
			return false;
		}
		
		// == Check that the year is valid ==
		
		// Four characters
		if(releaseYear.length != 4){
			alert("Your year must have four numbers")
			return false
		}
		
		// Valid numbers
		if(!numsOnly.test(releaseYear)){
			alert("Your year must contain only numbers")
			return false
		}
		
		// Valid date range
		if(parseInt(releaseYear) < minYear || parseInt(releaseYear) > maxYear){
			alert("The year you enterd is out of range. Range(" + minYear + "-" + maxYear + ")")
			return false
		}
		
		// Check Duration
		if(!floatCheck.test(duration)){
			alert("Your Duration should be in the format of *.**")
			return false
		}
		
		// Check that song length is above zero
		if(duration == 0.0){
			alert("Your Duration should be a valid length")
			return false
		}
}
