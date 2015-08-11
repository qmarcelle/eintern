
/*----------income--------------*/

$('#deleteIncomeModal').on('show.bs.modal', function(e) {

			var $modal = $(this), esseyId = e.relatedTarget.id;

			//            $.ajax({
			//                cache: false,
			//                type: 'POST',
			//                url: 'backend.php',
			//                data: 'EID='+essay_id,
			//                success: function(data) 
			//                {
			$modal.find('.edit-content').html(esseyId);
			//                }
			//            });

			$('.deleteBut').click(function() {
				window.location = "deleteIncome.do?id=" + esseyId;
			});
			/* <a href="deleteExpense.do?id=${expense.iD}" class="btn btn-danger btn-xs" id="${expense.iD}"> */

		})
		
		
		$('#editIncomeModal').on('show.bs.modal', function(e) {

			var $modal = $(this), esseyId = e.relatedTarget.id;

			$('#edit-id').val(esseyId);
			//            $.ajax({
			//                cache: false,
			//                type: 'POST',
			//                url: 'backend.php',
			//                data: 'EID='+essay_id,
			//                success: function(data) 
			//                {
			$modal.find('.edit-content').html(esseyId);
			//                }
			//            });

			$('.saveBut').click(function() {
				window.location = "editincomes.do"/* ?id=" + esseyId + "" */;
			});
			/* <a href="deleteExpense.do?id=${expense.iD}" class="btn btn-danger btn-xs" id="${expense.iD}"> */

		})
		
		/*-----------expense------------*/
		
		
		$('#deleteExpenseModal').on('show.bs.modal', function(e) {

			var $modal = $(this), esseyId = e.relatedTarget.id;

			//            $.ajax({
			//                cache: false,
			//                type: 'POST',
			//                url: 'backend.php',
			//                data: 'EID='+essay_id,
			//                success: function(data) 
			//                {
			$modal.find('.edit-content').html(esseyId);
			//                }
			//            });

			$('.deleteBut').click(function() {
				window.location = "deleteExpense.do?id=" + esseyId;
			});
			/* <a href="deleteExpense.do?id=${expense.iD}" class="btn btn-danger btn-xs" id="${expense.iD}"> */

		})
		
		
		$('#editExpenseModal').on('show.bs.modal', function(e) {

			var $modal = $(this), esseyId = e.relatedTarget.id;

			$('#edit-id').val(esseyId);
			//            $.ajax({
			//                cache: false,
			//                type: 'POST',
			//                url: 'backend.php',
			//                data: 'EID='+essay_id,
			//                success: function(data) 
			//                {
			$modal.find('.edit-content').html(esseyId);
			//                }
			//            });

			$('.saveBut').click(function() {
				window.location = "editexpenses.do"/* ?id=" + esseyId + "" */;
			});
			/* <a href="deleteExpense.do?id=${expense.iD}" class="btn btn-danger btn-xs" id="${expense.iD}"> */

		})
		
		
		



		
		