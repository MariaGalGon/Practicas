import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaCibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout id="vaadinHorizontalLayout" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" id="vaadinHorizontalLayout" theme="spacing-xl">
 <label id="id_cibernauta" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);"></label>
 <p id="estado_cibernauta"></p>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-cibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCibernauta.is, VistaCibernauta);
