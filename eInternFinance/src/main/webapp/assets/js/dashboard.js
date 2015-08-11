Chart.defaults.global.responsive=false;
Chart.defaults.global.maintainAspectRatio=false;


/*expense values*/
var projects = $("#projects").attr('value');
var resources = $("#resources").attr('value');
var travel = $("#travel").attr('value');
var utilities = $("#utilities").attr('value');
var marketing = $("#marketing").attr('value');
var other = $("#other").attr('value');
		
/*income values*/
		
var consult = $("#consult").attr('value');
var intensive = $("#intensive").attr('value');
var seminar = $("#seminar").attr('value');
var media = $("#media").attr('value');		
		
		
		
		
		var expenseData = [
            {
                value: projects,
                color:"#33CC33",
                highlight: "#99E699",
                label: "projects"
            },
            {
                value: travel,
                color: "#0066FF",
                highlight: "#80B2FF",
                label: "travel"
            },
            {
                value: resources,
                color: "#FFFF00",
                highlight: "#FFFFB2",
                label: "resources"
            },
            {
                value: utilities,
                color:"#FF0000",
                highlight: "#FF9494",
                label: "utilities"
            },
            {
                value: marketing,
                color: "#FF6699",
                highlight: "#FFA3C2",
                label: "marketing"
            },
            {
                value: other,
                color: "#CC33FF",
                highlight: "#E699FF",
                label: "other"
            }
            
        ]
		
		
		
		
		var incomeData = [
		            {
		                value: consult,
		                color:"#33CC33",
		                highlight: "#99E699",
		                label: "consultations"
		            },
		            {
		                value: intensive,
		                color: "#0066FF",
		                highlight: "#80B2FF",
		                label: "intensives"
		            },
		            {
		                value: media,
		                color:"#FFFF00",
		                highlight: "#FFFFB2",
		                label: "media sales"
		            },
		            
		            {
		                value: seminar,
		                color: "#FF0000",
		                highlight: "#FF9494",
		                label: "seminars"
		            }
		      
		        ]
		
	
		
		
		
var options = {
    scaleFontColor: "#f00",
    datasetStrokeWidth: 5
};
		

		var options2 = {
			    scaleFontColor: "#f00",
			    datasetStrokeWidth: 5
			};		
		
		// Get the context of the canvas element we want to select
var ctx = document.getElementById("expenseChart").getContext("2d");
//And for a doughnut chart
var myExpenseChart = new Chart(ctx).Doughnut(expenseData,options);


// Get the context of the canvas element we want to select
var ctx2 = document.getElementById("incomeChart").getContext("2d");
//And for a doughnut chart
var myIncometChart = new Chart(ctx2).Doughnut(incomeData,options2);



/*myExpenseChart.generateLegend();*/




