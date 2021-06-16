import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        		
                }
#vaadinVerticalLayout {
   background-color: #f5f5f5;
}
#vaadinVerticalLayout:hover {
   background-color: #dfeff2;
        border-radius: 10px;
}
            </style>
<vaadin-vertical-layout id="vaadinVerticalLayout" style="width: 100%; height: 100%;  border-radius: 10px; margin-bottom: var(--lumo-space-m);">
 <img id="imagen_producto" style="flex-grow: 0; align-self: center; border-radius: 10px;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; margin-bottom: var(--lumo-space-xs); width: auto;">
  <label id="nombre_producto" style="align-self: center; flex-grow: 0; font-weight: bold;"></label>
  <p id="tachado" style="text-decoration: line-through; flex-grow: 1; width: auto; align-self: stretch;"></p>
  <p id="precio_producto" style="align-self: center; flex-grow: 1; width: auto; align-self: stretch;"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; margin-top: var(--lumo-space-xs);">
  <label id="label_oferta_producto" style="align-self: center;">Hasta:</label>
  <p id="fecha_oferta_producto" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-producto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProducto.is, VistaProducto);
