import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-pedidocibernauta.js';

class VistaListapedidoscibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="justify-content: center; flex-wrap: wrap; width: 100%;" id="lista_pedidos" theme="spacing-xl">

</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listapedidoscibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListapedidoscibernauta.is, VistaListapedidoscibernauta);
