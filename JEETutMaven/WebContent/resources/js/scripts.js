$(document).ready(function() {

	$(".form-control").click(function() {
	    this.select();
	});
	
	
	$(".losbutton").click( 
		function(){
			// this.value --> id des loses
			console.log("button click, los id: "+this.value);
			
			updateLos(this.value);
			this.disabled = true;
		}
	);
	
	function updateLos(losId) {
		
		// url des servlets
		$.getJSON("/JEETutMaven/BuyLosServlet?losID="+losId, function(string) {
			if (string==="ok")
				{
				alert("Sie haben das Los mit der Nummer "+losId+" gekauft.");
				}
			else {
				alert("Dieses Los wurde bereits verkauft. Bitte wählen Sie ein anderes Los.");
			}
			
		});
	}
});

