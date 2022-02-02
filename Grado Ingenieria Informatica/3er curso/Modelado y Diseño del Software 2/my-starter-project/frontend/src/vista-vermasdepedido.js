import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './vista-listproductoscomprados.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import './vista-vertrabajadores.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaVermasdepedido extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="ver_mas_de_pedido">
 <h2 id="nombre_pedido"></h2>
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch;" id="cuadro_contenido">
  <vaadin-vertical-layout theme="spacing" id="hueco_lista"></vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" id="resumen_estado" style="flex-grow: 1; align-items: center;">
   <vaadin-vertical-layout id="cuadro_resumen" style="flex-grow: 1; width: 70%; margin: var(--lumo-space-xl); align-self: center; align-items: center;">
    <h3 id="titulo_resumen" style="align-self: center;">Resumen</h3>
    <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0; align-items: center; align-self: stretch;">
     <h5>Subtotal:</h5>
     <p id="subtotal"></p>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout theme="spacing" style="align-items: center; align-self: stretch;">
     <h5>Envío:</h5>
     <p id="envio"></p>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout theme="spacing" style="align-items: center; align-self: stretch;">
     <h5>Total:</h5>
     <p id="total"></p>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="align-self: stretch; align-items: center;">
    <h3 id="h3">Estado</h3>
    <label id="estado"></label>
    <vaadin-button id="boton_cancelar" style="align-self: center;">
      Cancelar 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-vermasdepedido';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVermasdepedido.is, VistaVermasdepedido);
