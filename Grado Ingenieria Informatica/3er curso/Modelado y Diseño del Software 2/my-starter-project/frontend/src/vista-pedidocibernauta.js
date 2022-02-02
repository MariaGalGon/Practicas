import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaPedidocibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 120%; height: 120%; background-color: #f5f5f5; border-radius: 10px; margin-bottom: var(--lumo-space-m); align-items: flex-start; padding-left: var(--lumo-space-m); padding-bottom: var(--lumo-space-s);" id="pedido_cibernauta">
 <h4 id="titulo_pedido" style="align-self: center;"></h4>
 <vaadin-horizontal-layout theme="spacing" style="align-items: center; justify-content: flex-start;" id="hor1">
  <label id="estado_label" style="font-weight: bold;">Estado:</label>
  <p id="estado"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-items: center; justify-content: flex-start;" id="hor2">
  <label id="num_productos_label" style="font-weight: bold;">Número de productos:</label>
  <p id="num_productod"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-items: center; justify-content: flex-start;" id="hor3">
  <label id="precio_label" style="font-weight: bold;">Precio:</label>
  <p id="precio"></p>
 </vaadin-horizontal-layout>
 <vaadin-button id="boton_mas_detalles" style="align-self: center;">
   Más Detalles 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-pedidocibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPedidocibernauta.is, VistaPedidocibernauta);
