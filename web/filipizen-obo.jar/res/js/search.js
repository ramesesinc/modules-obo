$(document).ready(function() {
    $( "#search-button" ).click(function() {
        search();
    });

    $('#search-field').on('keyup', function(e) {
    if (e.keyCode === 13) {
        search();
    }
    });

    $('.toggle').click(function (event) {
        event.preventDefault();
        var target = $(this).attr('href');
        $(target).toggleClass('hidden show');
    });

    $("#btnExportExcel").click(function(e) {
    e.preventDefault();


    var data_type = 'data:application/vnd.ms-excel';
    var table_div = document.getElementById('table_wrapper');
    var table_html = table_div.outerHTML.replace(/ /g, '%20');

    var a = document.createElement('a');
    a.href = data_type + ', ' + table_html;
    a.download = 'exported_table' + '.xls';
    a.click();
  });


  $('#btnExportPdf').click(function () {
        var doc = new jsPDF();
        var specialElementHandlers = {
          '#editor': function (element, renderer) {
              return true;
          }
        };
      doc.fromHTML($('#table_wrapper').html(), 15, 15, {
          'width': 170,
              'elementHandlers': specialElementHandlers
      });
      doc.save('exported_pdf.pdf');
      
  });

  $('#local').live('change', function(){
      if ( $(this).is(':checked') ) {
         $('#plocal').show();
     } else {
         $('#plocal').hide();
     }
   });
  
  $('#othercountries').live('change', function(){
     if ( $(this).is(':checked') ) {
         $('#ocountries').show();
     } else {
         $('#ocountries').hide();
     }
   });

});

function goBack() {
    window.history.back();
}
function goForward() {
    window.history.forward();
}
function search(){
    searchtext = $('#search-field').val();
    if(searchtext.length > 0){
        window.location.href = "result?search=" + searchtext ;
    }
};

function advancesearch(){
    
    var barangay = $( "#brgy option:selected" ).text();
    var skill = $( "#skill" ).val();
    var gender = $( "#gender option:selected" ).text();
    var education = $( "#education option:selected" ).text();
    var profession = $( "#profession option:selected" ).text();

    window.location.href = "result?barangay=" + barangay + "&skill=" + skill + "&gender=" + gender + "&education=" + education +"&profession=" + profession;
};
                    
function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifYes').style.display = 'block';
    }
    else document.getElementById('ifYes').style.display = 'none';
}


