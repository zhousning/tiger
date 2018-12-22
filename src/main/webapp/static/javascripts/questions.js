$(document).ready(function() {
	$("select[name='subject.id']").change(function() {
		var subject_id = $(this).val();
		var url = "subjects/" + subject_id + "/examPoints"
		$.get(url, function(result) {
			var examPoint = $("select[name='examPoint.id']");
			var option = "";
			$.each(result, function(key, value) {
				option += "<option value='" + key + "'>" + value + "</option>";
			});
			examPoint.html(option);
		});
	});

	$('.newbtn').bind("click", function() {
		$('#pic').click();
	});
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah')
				.attr('src', e.target.result);
		};

		reader.readAsDataURL(input.files[0]);
	}
}