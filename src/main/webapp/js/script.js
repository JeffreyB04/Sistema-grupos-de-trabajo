/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function init() {
    fetch('ServicioEstudiantes')
            .then(r => r.json())
            .then(d => actualizarTabla(d));
    console.log('Página inicializada..');
}

function actualizarTabla(datos) {
    var refTabla = document.getElementById('datosE');
    if (refTabla) {
        datos.forEach((v, i, datos) => {
            let fila = refTabla.insertRow(-1);
            Object.keys(v).forEach(atributo => {
                fila.insertCell(-1).textContent = v[atributo];
            });
        });
    }
}

window.addEventListener('load', init);
