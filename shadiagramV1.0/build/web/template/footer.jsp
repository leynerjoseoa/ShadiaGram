


<footer class="footer py-2 text-center">
    <div class="container"> <p>Sergio Buitrago - Leyner - V1.0</p> </div>
</footer>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
                                       $(document).ready(main);
                                       var contador = 1;
                                       function main() {
                                           $('.menu_bar').click(function () {
                                               $('nav').toggle();

                                               /*if (contador === 1) {
                                                $('nav').animate({
                                                left: '0'
                                                });
                                                contador = 0;
                                                } else {
                                                contador = 1;
                                                $('nav').animate({
                                                left: '-100%'
                                                });
                                                }*/
                                           });
                                       }
                                       ;
</script>
<script src="js/BuscadorTabla.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>