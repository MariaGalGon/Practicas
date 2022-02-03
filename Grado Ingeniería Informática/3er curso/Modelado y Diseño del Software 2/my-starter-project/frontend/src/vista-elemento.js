import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaElemento extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" theme="spacing-xl" id="vaadinHorizontalLayout" theme="spacing-xl">
 <vaadin-checkbox id="checkbox_elemento" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);">
 </vaadin-checkbox>
 <p id="detalles_elemento"></p>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-elemento';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaElemento.is, VistaElemento);
