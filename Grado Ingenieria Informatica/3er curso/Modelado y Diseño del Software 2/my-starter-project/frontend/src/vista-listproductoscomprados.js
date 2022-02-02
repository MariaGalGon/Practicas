import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-productocomprado.js';

class VistaListproductoscomprados extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout theme="spacing-xl" style="width: 100%; flex-wrap: wrap; justify-content: center;" id="lista_productos_compra">

</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listproductoscomprados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListproductoscomprados.is, VistaListproductoscomprados);
