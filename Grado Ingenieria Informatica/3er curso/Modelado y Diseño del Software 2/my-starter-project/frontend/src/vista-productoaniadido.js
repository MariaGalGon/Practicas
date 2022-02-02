import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box-dropdown-wrapper.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box-item.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class VistaProductoaniadido extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout>
 <img id="imagen_producto_aniadido" style="flex-grow: 0;">
 <vaadin-horizontal-layout theme="spacing" id="informacion_producto_aniadido">
  <label style="align-self: center;" id="nombre_producto_aniadido">Nombre</label>
  <p style="align-self: center;" id="precio_producto_aniadido">0.0 €</p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <vaadin-button id="boton_eliminar_producto_aniadido">
    Eliminar 
  </vaadin-button>
  <vaadin-combo-box style="width: 20%;" id="cantidad_producto_aniadido">
    1 
  </vaadin-combo-box>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-productoaniadido';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductoaniadido.is, VistaProductoaniadido);
