//TODO Rename to a more accurate name
//Models the data shown 
angular.module('appCFC').factory('MainData', function() {
	function MainData(args) {
		this.usuario = args.usuario;// exercises || [];
		this.montoAsegurado = args.montoAsegurado;
		this.saldoActual = args.saldoActual;
		this.ocioso = args.ocioso;
		this.codigoSucursal = args.codigoSucursal;
		this.saldoAutorizado = args.saldoAutorizado;
		this.puntoReorden = args.puntoReorden;
		this.porcentajeUtilización = args.porcentajeUtilización;
		this.cashBehaviorDetail = {};
		this.currentBalanceHistory = {};
		
        this.byDateToday = args.byDateToday;
        this.byDateTomorrow = args.byDateTomorrow;
        this.byDayToday = args.byDayToday;
        this.byDayTomorrow = args.byDayTomorrow;

	}
	;
	// MainData.prototype.totalWorkoutDuration = function () {
	// if (this.exercises.length == 0) return 0;
	// var total = 0;
	// angular.forEach(this.exercises, function (exercise) {
	// total = total + (exercise.duration ? exercise.duration : 0);
	// });
	// return (this.restBetweenExercise ? this.restBetweenExercise : 0) *
	// (this.exercises.length - 1) + total;
	// }
	return MainData;
});