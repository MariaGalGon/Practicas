import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProductoresultado extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%; border-radius: 10px; margin-bottom: var(--lumo-space-m);" id="vaadinVerticalLayout">
 <img id="imagen_producto_resultado" style="flex-grow: 0; align-self: center; border-radius: 10px;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <label id="nombre_producto_resultado" style="align-self: center; font-weight: bold;"></label>
  <p id="precio_producto_resultado" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-productoresultado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductoresultado.is, VistaProductoresultado);
