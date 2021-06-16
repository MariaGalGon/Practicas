import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaProductoasociado extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" id="vaadinHorizontalLayout" theme="spacing-xl" theme="spacing-xl">
 <vaadin-checkbox dir="checkbox_producto" id="checkbox" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);"> 
 </vaadin-checkbox>
 <p id="descripcion_producto"> </p>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-productoasociado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductoasociado.is, VistaProductoasociado);
